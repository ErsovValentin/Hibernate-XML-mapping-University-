package com.hibernate.hbm.univesity;

import org.hibernate.Session;

import java.util.ArrayList;

public class GroupsDAO {

    public void addGroup(Groups group)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(group);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with addGroup \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateGroup(Groups group)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(group);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with updateGroup \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteGroup(Groups group)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(group);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with deleteGroup \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public ArrayList<Groups> getAllGroups()
    {
        Session session = null;
        ArrayList groups = new ArrayList<Groups>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            groups = (ArrayList<Groups>)session.createCriteria(Groups.class).list();
        }
        catch (Exception e)
        {
            System.out.println("Error with getAllGroups \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return  groups;
    }

    public Groups getGroupById(int groupId)
    {
        Session session = null;
        Groups group = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            group = (Groups)session.get(Groups.class,groupId);
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
        return group;
    }

    public Groups getGroupByStudent(Students student)
    {
        Session session = null;
        Groups group = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "select s.group from Students s where s.id = :studentID";
            group = (Groups)session.createQuery(hql)
                                    .setParameter("studentID",student.getId())
                                    .getSingleResult();
        }
        catch (Exception e)
        {
            System.out.println("Error with getGroupByStudent \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return group;
    }

    public ArrayList<Groups> getGroupsByProfessor(Professors professor)
    {
        Session session = null;
        ArrayList groups = new ArrayList<Groups>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "select p.groups from Professors p where p.id = :professorID";
            groups = (ArrayList<Groups>)session.createQuery(hql)
                                                .setParameter("professorID",professor.getId())
                                                .list();
        }
        catch (Exception e)
        {
            System.out.println("Error with getGroupsByProfessor \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return  groups;
    }

}
