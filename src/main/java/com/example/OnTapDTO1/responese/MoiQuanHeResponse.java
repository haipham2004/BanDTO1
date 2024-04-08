package com.example.OnTapDTO1.responese;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoiQuanHeResponse {
    private int id;
    private String ma;
    private String ten;
}
