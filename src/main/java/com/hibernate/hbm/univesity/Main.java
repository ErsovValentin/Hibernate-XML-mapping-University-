package com.hibernate.hbm.univesity;

import java.util.ArrayList;

public class Main {
    public static void printAllGroups()
    {
        for(Groups g:Factory.getInstance().getGroupsDAO().getAllGroups())
        {
            System.out.println(g);
        }
    }

    public static void printAllProfessors()
    {
        for (Professors p:Factory.getInstance().getProfessorsDAO().getAllProfessors())
        {
            System.out.println(p);
        }
    }

    public static void printAllStudents()
    {
        for (Students s:Factory.getInstance().getStudentsDAO().getAllStudents())
        {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        GroupsDAO groupsDAO = Factory.getInstance().getGroupsDAO();
        ProfessorsDAO professorsDAO = Factory.getInstance().getProfessorsDAO();
        StudentsDAO studentsDAO = Factory.getInstance().getStudentsDAO();

        /*Groups groupAdd = new Groups();
        groupAdd.setName("FL996");
        groupAdd.setFaculty(Faculty.Languages);
        groupsDAO.addGroup(groupAdd);*/

        /*Groups groupUpdate = groupsDAO.getGroupById(3);
        groupUpdate.setName("FL2996");
        groupsDAO.updateGroup(groupUpdate);*/

//        groupsDAO.deleteGroup(groupsDAO.getGroupById(3));

        /*ArrayList<Groups> groupsByProfessor = groupsDAO.getGroupsByProfessor(professorsDAO.getProfessorById(2));
        for(Groups g : groupsByProfessor)
        {
            System.out.println(g);
        }*/


//        Main.printAllGroups();

        /*Professors professorAdd = new Professors();
        professorAdd.setName("Mariana NAZIMA");
        professorAdd.setExperience(19);
        professorsDAO.addProfessor(professorAdd);*/

        /*Professors professorUpdate = professorsDAO.getProfessorById(1);
        professorUpdate.setName("Pavel Emelianov");
        professorsDAO.updateProfessor(professorUpdate);*/

//        professorsDAO.deleteProfessor(professorsDAO.getProfessorById(3));

        /*ArrayList<Professors> professorsByGroup = professorsDAO.getProfessorsByGroup(groupsDAO.getGroupById(1));
        for(Professors p : professorsByGroup)
        {
            System.out.println(p);
        }*/

//        Main.printAllProfessors();

       /* Students studentAdd = new Students();
        studentAdd.setName("Malocca Rihteshtein");
        studentAdd.setDateOfBirth("1999-01-15");
        studentAdd.setGroup(groupsDAO.getGroupById(2));
        studentsDAO.addStudent(studentAdd);*/

       /* Students studentUpdate = studentsDAO.getStudentById(3);
        studentUpdate.setName("Avraham Licoln");
        studentsDAO.updateStudent(studentUpdate);*/

//       studentsDAO.deleteStudent(studentsDAO.getStudentById(3));

        //System.out.println(studentsDAO.);

        /*for(Students s: studentsDAO.getStudentsByGroup(groupsDAO.getGroupById(2)))
        {
            System.out.println(s);
        }*/



//        Main.printAllStudents();



    }
}
