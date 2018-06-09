package com.hibernate.hbm.univesity;

public class Factory {
    private static GroupsDAO groupsDAO = null;
    private static ProfessorsDAO professorsDAO = null;
    private static StudentsDAO studentsDAO = null;
    private static Factory instance = null;


    public static Factory getInstance()
    {
        if(instance == null)
        {
            instance = new Factory();
        }
        return instance;
    }

    public GroupsDAO getGroupsDAO()
    {
        if(groupsDAO == null)
        {
            groupsDAO = new GroupsDAO();
        }
        return groupsDAO;
    }

    public ProfessorsDAO getProfessorsDAO()
    {
        if(professorsDAO == null)
        {
            professorsDAO = new ProfessorsDAO();
        }
        return professorsDAO;
    }

    public StudentsDAO getStudentsDAO()
    {
        if(studentsDAO == null)
        {
            studentsDAO = new StudentsDAO();
        }
        return studentsDAO;
    }
}
