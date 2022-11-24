package edu.eci.arsw.PaperMind.backend.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.eci.arsw.PaperMind.backend.model.Biblioteca;
import edu.eci.arsw.PaperMind.backend.services.BibliotecaServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BibliotecaControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BibliotecaServices bibliotecaServices;

    @Autowired
    private ObjectMapper objectMapper;

    private Biblioteca biblioteca;

    private List<Biblioteca> bibliotecas;

    @BeforeEach
    public void inicializarVariables(){
        biblioteca = new Biblioteca();
        biblioteca.setNombre("Biblioteca 01");
        biblioteca.setFecha_creacion(new Date(2022 - 11 - 22));
        biblioteca.setFecha_modificacion(new Date(2022 - 11 - 22));
        biblioteca.setDescripcion("Hola");

        bibliotecas = new ArrayList<>();
        bibliotecas.add(biblioteca);
    }

    @DisplayName("Test Guardar Biblioteca.")
    @Test
    void testSaveBiblioteca() throws Exception {
        //given
        given(bibliotecaServices.saveBiblioteca(biblioteca))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when
        ResultActions response = mockMvc.perform(post("/api/bibliotecas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(biblioteca)));

        //then
        response.andDo(print())
                .andExpect(status().isOk());
    }

    @DisplayName("Test Buscar Bibliotecas.")
    @Test
    void testFindAllBibliotecas() throws Exception {
        //given
        given(bibliotecaServices.getBibliotecas()).willReturn(bibliotecas);

        //when
        ResultActions response = mockMvc.perform(get("/api/bibliotecas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(biblioteca)));

        //then
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre",is("Biblioteca 01")))
                .andExpect(jsonPath("$[0].descripcion",is("Hola")));
    }

    @DisplayName("Test Buscar Biblioteca por nombre.")
    @Test
    void testFindBibliotecaByName() throws Exception {
        //given
        given(bibliotecaServices.getBibliotecaByName("Biblioteca 01")).willReturn(biblioteca);

        //when
        ResultActions response = mockMvc.perform(get("/api/bibliotecas/{name}","Biblioteca 01")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(biblioteca)));

        //then
        response.andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.nombre",is("Biblioteca 01")))
                .andExpect(jsonPath("$.descripcion",is("Hola")));
    }

    @DisplayName("Test Actualizar Biblioteca por nombre.")
    @Test
    void testUpdateBibliotecaByName() throws Exception {
        //given
        String name = "Biblioteca 01";

        Biblioteca bibliotecaActualizada = new Biblioteca();
        bibliotecaActualizada.setNombre("Biblioteca 02");
        bibliotecaActualizada.setFecha_creacion(new Date(2022 - 11 - 22));
        bibliotecaActualizada.setFecha_modificacion(new Date(2022 - 11 - 22));
        bibliotecaActualizada.setDescripcion("Hola Mundo");

        given(bibliotecaServices.updateBiblioteca(name,biblioteca))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when
        ResultActions response = mockMvc.perform(put("/api/bibliotecas/{name}",name)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bibliotecaActualizada)));

        //then
        response.andDo(print())
                .andExpect(status().isOk());
    }


}
