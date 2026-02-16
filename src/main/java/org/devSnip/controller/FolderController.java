package org.devSnip.controller;

import lombok.RequiredArgsConstructor;
import org.devSnip.dto.FolderDto;
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
        public void addCategory(@RequestBody FolderDto folderDto){
            folderService.addFolder(folderDto);
        }

        @PutMapping("/updateCategory/{id}")
        public void updateCategory(@PathVariable Integer id , @RequestBody FolderDto folderDto){
            folderService.updateFolder(id, folderDto);
        }

        @GetMapping ("/{id}")
        public FolderDto viewCategory(@PathVariable Integer id){
            return folderService.viewFolder(id);
        }

        @GetMapping("/get-all")
        public List<FolderDto> viewAllCategory(){
            return folderService.viewAllFolder();
        }

        @DeleteMapping ("/delete/{id}")
        public void deleteUser(@PathVariable Integer id){
            folderService.deleteFolder(id);
        }
}
