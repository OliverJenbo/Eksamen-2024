package dashboard.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private boolean invited;
    private boolean accepted;
    private boolean checkedIn;
    private String status;

    @ManyToMany(mappedBy = "athletes")
    private Set<Competition> competitions = new HashSet<>();


    // Constructors, getters and setters
    public Athlete() {
    }

    public Athlete(String name, String email, boolean invited, boolean accepted, boolean checkedIn, String status) {
        this.name = name;
        this.email = email;
        this.invited = invited;
        this.accepted = accepted;
        this.checkedIn = checkedIn;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isInvited() {
        return invited;
    }

    public void setInvited(boolean invited) {
        this.invited = invited;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
    }
}
