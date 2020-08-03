package pl.pszczolkowski.teai82;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin("*")
public class NoteApi {

    private NotesRepo notesRepo;

    @Autowired
    public NoteApi(NotesRepo notesRepo) {
        this.notesRepo = notesRepo;
//        Note note = new Note("Były sobie świnki trzy", new Date(), new Date());
//        notesRepo.save(note);
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return notesRepo.findAll();
    }

    @PostMapping
    public String addNote(@RequestBody Note note) {
        note.creationDate = new Date();
        note.editingDate = new Date();
        notesRepo.save(note);
        return "Saved";
    }

    @PostMapping("/edit")
    public String editNote(@RequestParam long id, @RequestBody Note note){
        if (notesRepo.findById(id).isPresent()) {
            Note noteId = notesRepo.findById(id).get();
            noteId.text = note.text;
            noteId.editingDate = new Date();
            notesRepo.save(noteId);
            return "Edited!";
        }
        return "Not exist!";
    }
}
