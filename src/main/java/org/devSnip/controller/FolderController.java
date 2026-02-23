package org.devSnip.controller;

import lombok.RequiredArgsConstructor;
import org.devSnip.model.Folder;
import org.devSnip.service.FolderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/folder")
public class FolderController {
        private final FolderService folderService;

        @PostMapping("/add")
        public boolean addFolder(@RequestBody Folder folder){
            return folderService.addFolder(folder);
        }

        @PatchMapping("/updateFolder/{id}")
        public void updateCategory(@PathVariable Integer id , @RequestBody Folder folder){
            folderService.updateFolder(id, folder);
        }

        @GetMapping("/get-all")
        public List<Folder> viewAllFolder(){
            return folderService.viewAllFolder();
        }

        @DeleteMapping ("/delete/{id}")
        public void deleteFolder(@PathVariable Integer id){
            folderService.deleteFolder(id);
        }
}
