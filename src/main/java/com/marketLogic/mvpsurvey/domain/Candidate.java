package com.marketLogic.mvpsurvey.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "candidate")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_seq")
    @SequenceGenerator(name = "candidate_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "candidate_id")
    private int candidateId;
    private String name;
    private String email;

    @ElementCollection
    @OneToMany(mappedBy = "candidateResponseId")
    private List<CandidateResponse> candidateResponse;

    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL)
    private List<Survey> surveys;
}
