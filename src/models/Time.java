package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "times")
@NamedQueries({
    @NamedQuery(
        name = "getAllTimes",
        query = "SELECT t FROM Time AS t ORDER BY t.id DESC"
    ),
    @NamedQuery(
        name = "getTimesCount",
        query = "SELECT COUNT(t) FROM Time AS t"
    ),
})
@Entity
public class Time {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "time_date", nullable = false)
    private Date time_date;

    @Column(name = "clock_in", nullable = false)
    private Timestamp clock_in;

    @Column(name = "break_start", nullable = true)
    private Timestamp break_start;

    @Column(name = "break_end", nullable = true)
    private Timestamp break_end;

    @Column(name = "clock_out", nullable = true)
    private Timestamp clock_out;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getTime_date() {
        return time_date;
    }

    public void setTime_date(Date time_date) {
        this.time_date = time_date;
    }


    public Timestamp getClock_in() {
        return clock_in;
    }

    public void setClock_in(Timestamp clock_in) {
        this.clock_in = clock_in;
    }

    public Timestamp getBreak_start() {
        return break_start;
    }

    public void setBreak_start(Timestamp break_start) {
        this.break_start = break_start;
    }

    public Timestamp getBreak_end() {
        return break_end;
    }

    public void setBreak_end(Timestamp break_end) {
        this.break_end = break_end;
    }

    public Timestamp getClock_out() {
        return clock_out;
    }

    public void setClock_out(Timestamp clock_out) {
        this.clock_out = clock_out;
    }

}