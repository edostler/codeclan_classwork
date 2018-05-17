public enum GenreType {

    COMEDY("In a modern sense, comedy refers to any discourse or work generally intended to be humorous or amusing by inducing laughter."),
    DRAMA("Drama is a genre of narrative fiction (or semi-fiction) intended to be more serious than humorous in tone."),
    FANTASY("Fantasy is a genre of fiction set in a fictional universe, often without any locations, events, or people referencing the real world."),
    HORROR("Horror is a genre of fiction which is intended to, or has the capacity to frighten, scare, disgust, or startle its readers or viewers by inducing feelings of horror and terror."),
    ROMANCE("Novels of this type of genre fiction place their primary focus on the relationship and romantic love between two people.");

    private final String description;

    GenreType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
