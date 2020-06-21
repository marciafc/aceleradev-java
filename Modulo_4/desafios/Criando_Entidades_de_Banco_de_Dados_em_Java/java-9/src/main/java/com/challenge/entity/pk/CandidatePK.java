package com.challenge.entity.pk;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Company;
import com.challenge.entity.User;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CandidatePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_candidate_user"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "acceleration_id",
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "fk_candidate_acceleration"))
    private Acceleration acceleration;

    @ManyToOne
    @JoinColumn(name = "company_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_candidate_company"))
    private Company company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidatePK)) return false;

        CandidatePK that = (CandidatePK) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (acceleration != null ? !acceleration.equals(that.acceleration) : that.acceleration != null) return false;
        return company != null ? company.equals(that.company) : that.company == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (acceleration != null ? acceleration.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }
}
