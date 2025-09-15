package com.ygorportes.usuario.business.converter;

import com.ygorportes.usuario.business.dto.EnderecoDTO;
import com.ygorportes.usuario.business.dto.TelefoneDTO;
import com.ygorportes.usuario.business.dto.UsuarioDTO;
import com.ygorportes.usuario.infrastructure.entity.Endereco;
import com.ygorportes.usuario.infrastructure.entity.Telefone;
import com.ygorportes.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecos(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefone(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEnderecos(List<EnderecoDTO> enderecoDTOS) {
        List<Endereco> enderecos = new ArrayList<>();
        for (EnderecoDTO enderecoDTO : enderecoDTOS) {
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTOS) {
        return telefoneDTOS.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(paraListaEnderecosDTO(usuario.getEnderecos()))
                .telefones(paraListaTelefoneDTO(usuario.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecosDTO(List<Endereco> enderecos) {
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();
        for (Endereco endereco : enderecos) {
            enderecosDTO.add(paraEnderecoDTO(endereco));
        }
        return enderecosDTO;
    }

    public EnderecoDTO paraEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefones) {
        return telefones.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone) {
        return TelefoneDTO.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }
}
