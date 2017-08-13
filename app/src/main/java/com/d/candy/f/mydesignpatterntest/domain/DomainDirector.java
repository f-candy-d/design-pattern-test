package com.d.candy.f.mydesignpatterntest.domain;

import android.content.Context;
import android.support.annotation.NonNull;

import com.d.candy.f.mydesignpatterntest.domain.service.Service;
import com.d.candy.f.mydesignpatterntest.infra.Repository;
import com.d.candy.f.mydesignpatterntest.infra.SharedPrefAndSqlRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daichi on 8/13/17.
 */

public class DomainDirector<T> {

    @NonNull final private Map<T, Service> mServiceMap;
    @NonNull final private Repository mRepository;

    public DomainDirector(@NonNull Context context) {
        mServiceMap = new HashMap<>();
        mRepository = new SharedPrefAndSqlRepository(context);
    }

    public void addService(@NonNull T key, @NonNull Service service) {
        mServiceMap.put(key, service);

        if (service instanceof RepositoryUser) {
            ((RepositoryUser) service).setRepository(mRepository);
        }
    }

    public Service getService(@NonNull T key) {
        if (mServiceMap.containsKey(key)) {
            return mServiceMap.get(key);
        } else {
            throwRequiredServiceDoesNotExistException();
            return null;
        }
    }

    public <U> U getAndCastService(@NonNull T key, Class<U> serviceClass) {
        Service service = getService(key);
        if (service != null && service.getClass() == serviceClass) {
            return serviceClass.cast(service);
        } else {
            throwRequiredServiceDoesNotExistException();
            return null;
        }
    }

    private void throwRequiredServiceDoesNotExistException() {
        throw new IllegalStateException("The required service does not exist");
    }
}
