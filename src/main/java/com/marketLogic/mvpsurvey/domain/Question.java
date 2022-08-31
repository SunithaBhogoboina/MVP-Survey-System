package com.marketlogic.mvpsurvey.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
    @SequenceGenerator(name = "question_seq", initialValue = 1, allocationSize = 1)
    private Integer questionId;
    private String question;

    @ManyToOne
    @JoinColumn(name = "surveyId")
    @JsonBackReference
    private Survey survey;

    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL)
    @JsonInclude
    private List<Answer> answers;
    private Integer noOfResponse;
}
