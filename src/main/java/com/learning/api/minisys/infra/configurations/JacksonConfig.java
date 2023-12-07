package com.learning.api.minisys.infra.configurations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.learning.api.minisys.dtos.integrante.IntegranteEnderecoDto;
import com.learning.api.minisys.dtos.integrante.IntegranteGuidGrupoDto;
import com.learning.api.minisys.dtos.integrante.IntegranteGuidDto;
import com.learning.api.minisys.dtos.usuario.UsuarioDto;
import com.learning.api.minisys.dtos.usuario.UsuarioGrupoDto;
import com.learning.api.minisys.dtos.usuario.UsuarioGrupoGuidDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.UUID;

@Configuration
public class JacksonConfig {


    @Bean
    public SimpleModule integranteGuidGrupoDtoDeserializerModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(IntegranteGuidGrupoDto.class, new JsonDeserializer<>() {
            @Override
            public IntegranteGuidGrupoDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                return new IntegranteGuidGrupoDto(UUID.fromString(p.getValueAsString()));
            }
        });
        return module;
    }

    @Bean
    public SimpleModule integranteGuidDtoDeserializerModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(IntegranteGuidDto.class, new JsonDeserializer<>() {
            @Override
            public IntegranteGuidDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                return new IntegranteGuidDto(UUID.fromString(p.getValueAsString()));
            }
        });
        return module;
    }

    @Bean
    public SimpleModule usuarioGrupoGuidDtoDeserializerModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(UsuarioGrupoGuidDto.class, new JsonDeserializer<>() {
            @Override
            public UsuarioGrupoGuidDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                return new UsuarioGrupoGuidDto(UUID.fromString(p.getValueAsString()));
            }
        });
        return module;
    }

}