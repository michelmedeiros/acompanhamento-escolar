package br.com.acompanhamento.domains;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by miche on 19/02/2017.
 */
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "alunos")
public class Aluno {

    @Id
    private String id;

    private String nome;

    private int idade;

}
