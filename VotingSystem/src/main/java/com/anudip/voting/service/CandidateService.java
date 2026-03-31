package com.anudip.voting.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.anudip.voting.entity.Candidate;
import com.anudip.voting.util.HibernateUtil;

public class CandidateService {

    public void showCandidates() {

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        Query<Candidate> query =
                session.createQuery(
                "FROM Candidate",
                Candidate.class);

        List<Candidate> list =
                query.list();

        System.out.println("\n===== Candidate List =====");

        for (Candidate c : list) {

            System.out.println(
                "ID: " + c.getId()
                + " | Name: " + c.getName()
                + " | Party: " + c.getParty()
                + " | Votes: " + c.getVotes());
        }

        session.close();
    }
}