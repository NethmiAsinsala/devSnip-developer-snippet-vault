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

        @PostMapping("/addCategory")
        public void addFolder(@RequestBody Folder folder){
            folderService.addFolder(folder);
        }

//        @PutMapping("/updateCategory/{id}")
//        public void updateCategory(@PathVariable Integer id , @RequestBody FolderDto folderDto){
//            folderService.updateFolder(id, folderDto);
//        }
//
//        @GetMapping ("/{id}")
//        public FolderDto viewCategory(@PathVariable Integer id){
//            return folderService.viewFolder(id);
//        }

        @GetMapping("/get-all")
        public List<Folder> viewAllFolder(){
            return folderService.viewAllFolder();
        }

        @DeleteMapping ("/delete/{id}")
        public void deleteFolder(@PathVariable Integer id){
            folderService.deleteFolder(id);
        }
}
