package com.challenge.entity.pk;


import com.challenge.entity.Challenge;
import com.challenge.entity.User;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class SubmissionPK implements Serializable {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id",
                foreignKey = @ForeignKey(name = "fk_submission_user"))
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "challenge_id",
                foreignKey = @ForeignKey(name = "fk_submission_challenge"))
    private Challenge challenge;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubmissionPK)) return false;

        SubmissionPK that = (SubmissionPK) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return challenge != null ? challenge.equals(that.challenge) : that.challenge == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (challenge != null ? challenge.hashCode() : 0);
        return result;
    }
}
