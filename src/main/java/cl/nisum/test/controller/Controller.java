package cl.nisum.test.controller;

import cl.nisum.test.Entity.Telefono;
import cl.nisum.test.Entity.Usuario;
import cl.nisum.test.Repository.TelefonoRepository;
import cl.nisum.test.Repository.UsuarioRepository;
import cl.nisum.test.VO.RequestVO;
import cl.nisum.test.VO.ResponseGetAll;
import cl.nisum.test.VO.ResponseVO;
import cl.nisum.test.VO.TelefonoVO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

import static java.time.ZoneOffset.UTC;

@CrossOrigin
@RestController
@RequestMapping("/nisum/test/")
public class Controller {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TelefonoRepository telefonoRepository;

    public static final String ISSUER = "cl.nisum.test";
    private int expiracion = 10;
    byte[] secretKey = new byte[64];

    @CrossOrigin
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseVO> insert(@RequestBody RequestVO request){
    // TODO VALIDACIONES DE TIPO EXPRESIONES REGULARES
    // TODO MENSAJES DE ERROR

        Usuario usuario = new Usuario();
        usuario.setClave(request.getContrasena());
        usuario.setCorreo(request.getCorreo());
        usuario.setIsactive(true);
        ResponseVO usuario1 = usuarioRepository.getByCorreo(usuario.getCorreo());

        if (usuario1 == null){

            usuario = usuarioRepository.save(usuario);
            usuario.setToken(makeToken(usuario.getId().toString()));
            usuario = usuarioRepository.save(usuario);
            if (usuario != null){
                if (request.getTelefono().size() > 0){
                    Telefono telefono = new Telefono();
                    List<Telefono> telefonos = new ArrayList<>();

                    for (TelefonoVO telefonoVO: request.getTelefono()) {
                        telefono.setCitycode(telefonoVO.getCitycode());
                        telefono.setCountrycode(telefonoVO.getContrycode());
                        telefono.setIdsuario(usuario);
                        telefono.setNumber(telefonoVO.getNumber());
                        telefonos.add(telefono);
                    }
                    telefonos = telefonoRepository.saveAll(telefonos);
                }
            }

            List<Usuario> usuarioList = new ArrayList<>();
            usuarioList = usuarioRepository.findAll();
            usuario1 = usuarioRepository.getByCorreo(usuario.getCorreo());
            if (usuario1 ==null){
                usuario1.setCode(1);
                usuario1.setMensaje("Problemas insertando datos");
            }else{
                usuario1.setCode(0);
                usuario1.setMensaje("Datos insertados ");
            }
        }else{
            usuario1 = new ResponseVO();
            usuario1.setCode(2);
            usuario1.setMensaje("Correo ya registrado ");
        }

        return new ResponseEntity<ResponseVO>(usuario1, HttpStatus.OK);
    }



    private String makeToken(String userUUID) {
        String result = "";
        Date expiration = Date.from(LocalDateTime.now(UTC).plusMinutes(expiracion).toInstant(UTC));
        result = Jwts.builder().
                //setClaims(dataToEncripted).
                setSubject(userUUID).
                //setAudience(issuer).
                        setExpiration(expiration).
                        setIssuer(ISSUER).
                        signWith(SignatureAlgorithm.HS512, secretKey).
                        compact();
        return result;
    }
    @CrossOrigin
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ResponseGetAll>> getAll(@RequestBody RequestVO request){
        List<ResponseGetAll> responseGetAlls = new ArrayList<>();

        List<TelefonoVO> telefonos = new ArrayList<>();
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.size() != 0){
            for (Usuario user:usuarios) {
                telefonos = telefonoRepository.getByIdUsuario(user.getId());
                ResponseGetAll responseGetAll =
                        new ResponseGetAll(user.getId(), user.getCreated(), user.getModified(), user.getLast_login()
                                , user.getToken(), user.isIsactive(), user.getCorreo(), user.getClave()
                                ,  telefonos);
                responseGetAlls.add(responseGetAll);
            }
        }
        return new ResponseEntity<List<ResponseGetAll>>(responseGetAlls, HttpStatus.OK);
    }



}
