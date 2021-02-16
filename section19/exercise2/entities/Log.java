package section19.exercise2.entities;

import java.util.Date;
import java.util.Objects;

public class Log {
    private String user;
    private Date date;

    public Log(String user, Date date) {
        this.user = user;
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return user.equals(log.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
