package com.example.app2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name  = "name")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Name {
@Id
   private  String name ;
}
