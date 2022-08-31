package com.marketlogic.mvpsurvey.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "candidate_response")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CandidateResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "response_seq")
    @SequenceGenerator(name = "response_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "candidate_response_id")
    private Integer candidateResponseId;
    private String value;

    @ManyToOne
    @JoinColumn(name = "surveyId")
    @JsonBackReference
    private Survey survey;

    @ElementCollection
    @OneToMany(mappedBy = "answerId")
    @JsonManagedReference
    private List<Answer> answerList;

    @ManyToOne
    @JoinColumn(name = "candidateId")
    private Candidate candidate;

}
