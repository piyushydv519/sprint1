package com.anudip.voting.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.anudip.voting.entity.Candidate;
import com.anudip.voting.entity.Voter;
import com.anudip.voting.util.HibernateUtil;

public class VoteService {

    public void castVote(int voterId, int candidateId) {

        Session session = null;
        Transaction tx = null;

        try {

            session = HibernateUtil
                    .getSessionFactory()
                    .openSession();

            tx = session.beginTransaction();

            // Get voter
            Voter voter =
                    session.get(Voter.class, voterId);

            if (voter == null) {

                System.out.println("Voter not found!");
                tx.rollback();
                return;

            }

            // Check already voted
            if (voter.isVoted()) {

                System.out.println("Voter already voted!");
                tx.rollback();
                return;

            }

            // Get candidate
            Candidate candidate =
                    session.get(Candidate.class, candidateId);

            if (candidate == null) {

                System.out.println("Candidate not found!");
                tx.rollback();
                return;

            }

            // Increase vote
            candidate.setVotes(
                    candidate.getVotes() + 1);

            voter.setVoted(true);

            session.update(candidate);
            session.update(voter);

            tx.commit();

            System.out.println("Vote Cast Successfully!");

        }

        catch (Exception e) {

            if (tx != null)
                tx.rollback();

            e.printStackTrace();

        }

        finally {

            if (session != null)
                session.close();

        }
    }
}