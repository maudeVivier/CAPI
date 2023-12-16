import com.fasterxml.jackson.annotation.JsonProperty;

public enum ModeDeJeu {
    @JsonProperty("UNANIMITE")
    UNANIMITE,
    @JsonProperty("MOYENNE")
    MOYENNE
}
