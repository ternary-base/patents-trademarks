package br.gov.inpi.service;


import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.Usuario;
import br.gov.inpi.mapper.UsuarioMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UsuarioService {

    public void inserir(Usuario usuario) {

        if (usuario != null) {
            SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

            try {

                UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);

                List<Usuario> usuarios = usuarioMapper.getUsuario(usuario);

                if (usuarios == null || usuarios.size() == 0) {
                    usuarioMapper.inserir(usuario);
                }

                sqlSession.commit();

            } finally {
                sqlSession.close();
            }
        }
    }

    public List<Usuario> getUsuario(Usuario usuario) {

        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);

        return usuarioMapper.getUsuario(usuario);
    }
}
