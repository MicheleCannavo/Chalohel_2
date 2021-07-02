package chalohel.database.entity;


import com.github.zafarkhaja.semver.Version;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The type Project.
 */
public class Project {

    @Id
    private String idProject;

    @Column(name = "name_project",
        columnDefinition = "varchar(25) NOT NULL")
    private String nameProject;

    @Column(name = "VERSION",
        columnDefinition = "varchar(10) NOT NULL")
    private Version actualVersion;

    @Enumerated
    @Column(name = "STATUS",
        columnDefinition = "varchar(30) NOT NULL")
    private List<User> listDevelopments;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_AT",
        columnDefinition = "date NOT NULL")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "MODIFY_AT",
        columnDefinition = "date NOT NULL")
    private Date modifyDate;

    @Column(name="STATUS", nullable=false,
        columnDefinition="boolean not null default false")
    private boolean isClosed;

    /**
     * Instantiates a new Project.
     *
     * @param nameProject the name project
     */
    public Project(String nameProject) {
        this.nameProject = nameProject;
        this.idProject = "0";
        Version v = Version.valueOf("0.1.0-alpha.1+build.1");
        startDate = new Date();
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public String getIdProject() {
        return idProject;
    }

    /**
     * Sets id.
     *
     * @param idProject the id
     */
    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    /**
     * Gets name project.
     *
     * @return the name project
     */
    public String getNameProject() {
        return nameProject;
    }

    /**
     * Sets name project.
     *
     * @param nameProject the name project
     */
    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    /**
     * Gets actual version.
     *
     * @return the actual version
     */
    public Version getActualVersion() {
        return actualVersion;
    }

    /**
     * Gets list developments.
     *
     * @return the list developments
     */
    public List<User> getListDevelopments() {
        return listDevelopments;
    }

    /**
     * Sets list developments.
     *
     * @param listDevelopments the list developments
     */
    public void setListDevelopments(List<User> listDevelopments) {
        this.listDevelopments = listDevelopments;
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Is closed boolean.
     *
     * @return the boolean
     */
    public boolean isClosed() {
        return isClosed;
    }

    /**
     * Sets closed.
     *
     * @param closed the closed
     */
    public void setClosed(boolean closed) {
        isClosed = closed;
    }


    @Override
    public String toString() {
        return "ii.Project{" +
            "id='" + idProject + '\'' +
            ", nameProject='" + nameProject + '\'' +
            ", actualVersion=" + actualVersion +
            ", listDevelopments=" + listDevelopments +
            ", startDate=" + startDate +
            ", isClosed=" + isClosed +
            ", v=" +
            '}';
    }
}