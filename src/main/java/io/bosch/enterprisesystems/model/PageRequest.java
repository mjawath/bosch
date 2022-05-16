package io.bosch.enterprisesystems.model;

import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageRequest extends AbstractPageRequest {
    private String offSetAttribute;
    private String offSetValue;
    private String offSetType;
    private boolean isOffSetAsc;

    public PageRequest(int page, int size) {
        super(page, size);
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previous() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return null;
    }

    public String getOffSetAttribute() {
        return offSetAttribute;
    }

    public void setOffSetAttribute(String offSetAttribute) {
        this.offSetAttribute = offSetAttribute;
    }

    public String getOffSetValue() {
        return offSetValue;
    }

    public void setOffSetValue(String offSetValue) {
        this.offSetValue = offSetValue;
    }

    public String getOffSetType() {
        return offSetType;
    }

    public void setOffSetType(String offSetType) {
        this.offSetType = offSetType;
    }

    public boolean isOffSetAsc() {
        return isOffSetAsc;
    }

    public void setOffSetAsc(boolean offSetAsc) {
        isOffSetAsc = offSetAsc;
    }
}
