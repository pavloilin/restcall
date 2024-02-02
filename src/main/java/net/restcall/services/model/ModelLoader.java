package net.restcall.services.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.restcall.model.RequestFolder;
import net.restcall.model.Workspace;

public class ModelLoader {
	public void load(Workspace workspace) {
		List<RequestFolder> rootFolders = createSampleFolders();
		workspace.installFolders(rootFolders);
	}

	private List<RequestFolder> createSampleFolders() {
		List<RequestFolder> rootFolders = new ArrayList<>();
		RequestFolder folder1 = new RequestFolder("Folder1", "", new Date());
		rootFolders.add(folder1);
		
		RequestFolder folder2 = new RequestFolder();
		folder2.setName("folderII");
		rootFolders.add(folder2);
		
		RequestFolder folder3 = new RequestFolder();
		folder3.setName("folderThree");
		folder3.setDescription("the folder");
		folder3.setCreationDate(new Date());
		rootFolders.add(folder3);
		return rootFolders;
	}
}
