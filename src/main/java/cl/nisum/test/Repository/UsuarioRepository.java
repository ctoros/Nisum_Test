package cl.nisum.test.Repository;


import cl.nisum.test.Entity.Usuario;
import cl.nisum.test.VO.ResponseVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select new cl.nisum.test.VO.ResponseVO(r.id, r.created, r.modified, r.last_login, r.token, r.isactive, r.correo,r.clave) " +
            "from Usuario r " +
            "where r.correo = :correo")
    ResponseVO getByCorreo(@Param("correo") String correo);
}
