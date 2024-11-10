package com.example.Student_Management_System.ID;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class SixDigitIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        Random random = new Random();
        Long id = 100000 + random.nextLong(900000); // Generates a random 6-digit number
        return id;
    }
}

