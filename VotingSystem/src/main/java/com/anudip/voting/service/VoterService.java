
package com.anudip.voting.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.anudip.voting.entity.Voter;
import com.anudip.voting.util.HibernateUtil;

public class VoterService {

    public void showVoters() {

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();

        Query<Voter> query =
                session.createQuery(
                "FROM Voter",
                Voter.class);

        List<Voter> list =
                query.list();

        System.out.println("\n===== Voter List =====");

        for (Voter v : list) {

            System.out.println(
                "ID: " + v.getId()
                + " | Name: " + v.getName()
                + " | Email: " + v.getEmail()
                + " | Voted: " + v.isVoted());
        }

        session.close();
    }
}