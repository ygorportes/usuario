package com.ygorportes.usuario.business;

import com.ygorportes.usuario.business.converter.UsuarioConverter;
import com.ygorportes.usuario.business.dto.UsuarioDTO;
import com.ygorportes.usuario.infrastructure.entity.Usuario;
import com.ygorportes.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }
}
