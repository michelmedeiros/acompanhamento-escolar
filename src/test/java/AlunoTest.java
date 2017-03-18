
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import br.com.acompanhamento.domains.Aluno;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Michel Medeiros on 14/03/2017.
 */
public class AlunoTest {


    public static Response response;
    public static String jsonAsString;

    @BeforeClass
    public static void setupURL()
    {
        // here we setup the default URL and API base path to use throughout the tests
        baseURI = "http://localhost:8080";
        basePath = "/api/v1/";
    }

    @Test
    public void validaEnderecoJSON() {
        // call the rides API, the full address is "http://yourwebsiteaddress.com/api/yourapi/rides",
        // but we set the default above, so just need "/rides"
        response =
                when().
                        get("/alunos").
                        then().
                        contentType(ContentType.JSON).  // check that the content type return from the API is JSON
                        statusCode(200).
                        extract().response(); // extract the response
        // We convert the JSON response to a string, and save it in a variable called 'jsonAsString'
        jsonAsString = response.asString();

        List<Aluno> mcList = Arrays.asList(new Gson().fromJson(jsonAsString, Aluno[].class));
    }

    @Test
    public void sucessoAoBuscarUsuarios() {
        JsonPath path = given()
                .get("/alunos")
                .andReturn()
                .jsonPath();
        Aluno aluno = path.getObject("[0]", Aluno.class);
        assertThat(aluno, notNullValue());
    }


    @Test
    public void sucessoAoBuscarAlunoPorId() {
        JsonPath path = given()
                .param("id", 1)
                .get("/alunos")
                .andReturn()
                .jsonPath();
        Aluno aluno = path.getObject("[0]", Aluno.class);

        assertThat(aluno, notNullValue());
    }

    @Test
    public void sucessoAoBuscarInserirAluno() {

        Aluno aluno = Aluno.builder().id("9").idade(1).nome("Dedé").build();
        response =
                given()
                    .header("Accept", ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body(aluno)
                .expect()
                    .statusCode(201)
                .when()
                    .post("/alunos")
                .then()
                .extract().response();
        jsonAsString = response.asString();
        Aluno alunoInserido = new Gson().fromJson(jsonAsString, Aluno.class);
        assertThat(alunoInserido, notNullValue());
    }


    @Test
    public void sucessoAExcluirAluno() {

        Aluno aluno = Aluno.builder().id("999").idade(1).nome("Dedé").build();
        response =
                given()
                        .header("Accept", ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .body(aluno)
                        .expect()
                        .statusCode(201)
                        .when()
                        .post("/alunos")
                        .then()
                        .extract().response();
        jsonAsString = response.asString();

        Aluno alunoInserido = new Gson().fromJson(jsonAsString, Aluno.class);
        assertThat(alunoInserido, notNullValue());

        response = given().pathParam("id", alunoInserido.getId())
                .when().delete("/alunos/{id}")
                .then().statusCode(200).extract().response();

        assertThat(response.getStatusCode(), equalTo(200));
    }

}

/*
@Test
public void deveAdicionarUmUsuario() {

Usuario resposta = retorno.getObject("usuario", Usuario.class);
assertEquals("Joao da Silva", resposta.getNome());
assertEquals("joao@dasilva.com", resposta.getEmail());
// deletando aqui
given()
.contentType("application/xml").body(resposta)
.expect().statusCode(200)
.when().delete("/usuarios/deleta").andReturn().asString();
}
 */
