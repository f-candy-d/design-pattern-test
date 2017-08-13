package com.d.candy.f.mydesignpatterntest.domain;

import android.support.annotation.NonNull;

import com.d.candy.f.mydesignpatterntest.infra.Repository;
import com.d.candy.f.mydesignpatterntest.infra.SharedPrefAndSqlRepository;

/**
 * Created by daichi on 8/13/17.
 *
 * A Service class which will use a class which implements Repository interface must implement this interface.
 */

public interface RepositoryUser {

    void setRepository(@NonNull Repository repository);
}
