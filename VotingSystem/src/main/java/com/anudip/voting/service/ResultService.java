package com.anudip.voting.service;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.anudip.voting.entity.Candidate;
import com.anudip.voting.util.HibernateUtil;

public class ResultService {

    public void showWinner() {

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        Query<Candidate> query =
                session.createQuery(
                "FROM Candidate ORDER BY votes DESC",
                Candidate.class);

        query.setMaxResults(1);

        Candidate winner =
                query.uniqueResult();

        if (winner != null) {

            System.out.println(
                "Winner is: "
                + winner.getName());

            System.out.println(
                "Party: "
                + winner.getParty());

            System.out.println(
                "Votes: "
                + winner.getVotes());
        }

        session.close();
    }
}