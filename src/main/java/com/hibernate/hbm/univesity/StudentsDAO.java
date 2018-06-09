package com.hibernate.hbm.univesity;

import org.hibernate.Session;

import java.util.ArrayList;

public class StudentsDAO {

    public void addStudent(Students student)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with addStudent");
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateStudent(Students student)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(student);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with updateStudent \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteStudent(Students student)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with deleteStudent \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public ArrayList<Students> getAllStudents()
    {
        Session session = null;
        ArrayList students = new ArrayList<Students>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            students = (ArrayList<Students>)session.createCriteria(Students.class).list();
        }
        catch (Exception e)
        {
            System.out.println("Error with getAllStudents \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return  students;
    }

    public Students getStudentById(int studentId)
    {
        Session session = null;
        Students student = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            student = (Students)session.get(Students.class,studentId);
        }
        catch (Exception e)
        {
            System.out.println("Error with getStudentById \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return student;
    }

    public ArrayList<Students> getStudentsByGroup(Groups group)
    {
        Session session = null;
        ArrayList students = new ArrayList<Students>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql ="select g.students from Groups g where g.id = :groupID";
            students = (ArrayList<Students>)session.createQuery(hql)
                    .setParameter("groupID",group.getId())
                    .list();
        }
        catch (Exception e)
        {
            System.out.println("Error with getStudentsByGroup \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return students;
    }

   /* public ArrayList<Students> getStudentsByProfessor(Professors professor)
    {
        Session session = null;
        ArrayList students = new ArrayList<Students>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
//            String hql = "select g.students from Groups g inner join Professors p where p.id = :professorID";
//            students = (ArrayList<Students>)session.createQuery(hql)
//                    .setParameter("professorID",professor.getId())
//                    .list();
        }
        catch (Exception e)
        {
            System.out.println("Error with getStudentsByProfessor \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return students;
    }*/
}
