package app.config;

import jakarta.security.enterprise.identitystore.CredentialValidationResult;

public class CustomCredentialValidationResult extends CredentialValidationResult {

    private StatusLogin NOT_ACTIVE_USER;
    private StatusLogin CHANGE_PASSWORD;
    private StatusLogin INVALID_PASSWORD;

    private CredentialValidationResult credential;

    public CustomCredentialValidationResult() {
        super((String) null);
    }

    public CustomCredentialValidationResult setNotActif(StatusLogin notActiveUser) {
        NOT_ACTIVE_USER = notActiveUser;
        credential = CredentialValidationResult.INVALID_RESULT;
        return this;
    }

    public CustomCredentialValidationResult setChangePassword(StatusLogin changePassword) {
        CHANGE_PASSWORD = changePassword;
        credential = CredentialValidationResult.INVALID_RESULT;
        return this;
    }

    public CustomCredentialValidationResult setInvalidPassword(StatusLogin invalidPassword) {
        INVALID_PASSWORD = invalidPassword;
        credential = CredentialValidationResult.INVALID_RESULT;
        return this;
    }

    public StatusLogin getNOT_ACTIVE_USER() {
        return NOT_ACTIVE_USER;
    }

    public StatusLogin getCHANGE_PASSWORD() {
        return CHANGE_PASSWORD;
    }

    public StatusLogin getINVALID_PASSWORD() {
        return INVALID_PASSWORD;
    }

    public CredentialValidationResult getCredential() {
        return credential;
    }

    public void setCredential(CredentialValidationResult credential) {
        this.credential = credential;
    }
    

    public enum StatusLogin {
        NOT_ACTIVE_USER,
        INVALID_PASSWORD,
        CHANGE_PASSWORD,
    }
}
