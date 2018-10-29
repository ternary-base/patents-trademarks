package br.gov.inpi.mapper;

import br.gov.inpi.domain.Usuario;

import java.util.List;

public interface UsuarioMapper {

    void inserir(Usuario usuario);

    List<Usuario> getUsuario(Usuario usuario);

}
