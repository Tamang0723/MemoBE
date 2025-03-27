package com.example.RegisterLogin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String date;
    String tittle;
    String memos;
    String subject;





}

