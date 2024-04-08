package com.example.OnTapDTO1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BanRequest {

    private int id;

    private String ma;

    private String ten;

    private String soThich;

    private int gioiTinh;

    private int idMoiQuanHe;
}
