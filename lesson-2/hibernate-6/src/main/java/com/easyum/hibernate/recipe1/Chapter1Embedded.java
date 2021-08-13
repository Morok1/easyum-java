package com.easyum.hibernate.recipe1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Chapter1Embedded {
    @Getter
    @Setter
    String title;
    @Getter
    @Setter
    String content;
}
