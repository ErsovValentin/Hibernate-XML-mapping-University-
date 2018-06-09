package com.hibernate.hbm.univesity;

import org.hibernate.Session;

import java.util.ArrayList;

public class ProfessorsDAO {

    public void addProfessor(Professors professor)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(professor);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with addProfessor \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateProfessor(Professors professor)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(professor);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with updateProfessor \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteProfessor(Professors professor)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(professor);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with deleteProfessor \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public ArrayList<Professors> getAllProfessors()
    {
        Session session = null;
        ArrayList professors = new ArrayList<Professors>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            professors = (ArrayList<Professors>)session.createCriteria(Professors.class).list();
        }
        catch (Exception e)
        {
            System.out.println("Error with getAllProfessors \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return  professors;
    }

    public Professors getProfessorById(int professorId)
    {
        Session session = null;
        Professors professor = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            professor = (Professors) session.get(Professors.class,professorId);
        }
        catch (Exception e)
        {
            System.out.println("Error with getGroupById \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return professor;
    }

    public ArrayList<Professors> getProfessorsByGroup(Groups group)
    {
        Session session = null;
        ArrayList<Professors> professors = new ArrayList<Professors>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "select g.professors from Groups g where g.id = :groupID";
            professors = ( ArrayList<Professors>)session.createQuery(hql)
                    .setParameter("groupID",group.getId())
                    .list();
        }
        catch (Exception e)
        {
            System.out.println("Error with getProfessorsByGroup \n"+e);
        }
        finally
        {

        }
        return professors;
    }


}
