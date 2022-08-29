package com.marketLogic.mvpsurvey.domain;

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
@Table(name = "survey")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "survey_seq")
    @SequenceGenerator(name = "survey_seq", initialValue = 1, allocationSize = 1)
    private int surveyId;
    private String surveyTitle;
    private String surveyDescription;

    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Question> questions;

    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CandidateResponse> candidateResponseList;
}
