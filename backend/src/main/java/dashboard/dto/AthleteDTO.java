package dashboard.dto;

public class AthleteDTO {

    private Long id;
    private String name;
    private String email;
    private boolean invited;
    private boolean accepted;
    private boolean checkedIn;
    private String status;

    public AthleteDTO() {
    }

    public AthleteDTO(Long id, String name, String email, boolean invited, boolean accepted, boolean checkedIn, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.invited = invited;
        this.accepted = accepted;
        this.checkedIn = checkedIn;
        this.status = status;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
