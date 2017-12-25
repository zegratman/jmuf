package org.jmuf.core.api.modulation;

import org.jmuf.core.api.note.Note;

/**
 * A @{@link ModulatedNote} is a @{@link Note} with a @{@link NoteModulation} associated.
 * This extends the concept of musical note to the fact that it is physically played by an instrument.
 * Here, the instrument represented by the modulation is still played by a perfect player : no envelope nor
 * time decrease is applied to the note.
 */
public class ModulatedNote extends Note {

    /** The note modulation */
    private NoteModulation noteModulation;

    /**
     * Constructor
     * @param noteModulation the note modulation to use.
     */
    public ModulatedNote(NoteModulation noteModulation) {
        super();
        this.noteModulation = noteModulation;
    }

    /**
     * Get the note modulation
     * @return the note modulation associated
     */
    public NoteModulation getNoteModulation() {
        return noteModulation;
    }

    /**
     * Set the note modulation
     * @param noteModulation the modulation to set
     */
    public void setNoteModulation(NoteModulation noteModulation) {
        this.noteModulation = noteModulation;
    }

    /**
     * Compose previous modulation with another one.
     * This method can be very usefull to combine note sounds as the composition of simpler modulations.
     * @param otherModulation the modulation to compose with.
     */
    public void composeModulation(NoteModulation otherModulation) {
        this.noteModulation = (t) -> otherModulation.apply(this.noteModulation.apply(t));
    }
}
