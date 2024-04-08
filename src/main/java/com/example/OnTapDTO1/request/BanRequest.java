package com.example.OnTapDTO1.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BanRequest {

    private int id;

    private String ma;

    private String ten;

    private String soThich;

    private int gioiTinh;

    private int IdMoiQuanHe;
}
