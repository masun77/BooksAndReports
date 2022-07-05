package dataManipulation;

import java.util.ArrayList;

public class Category {
	private String name = "";
	private ArrayList<Category> subcategories = new ArrayList<Category>();
	private Category parentCategory = null;
	
	public Category(String n, Category parent, ArrayList<Category> subs) {
		name = n;
		parentCategory = parent;
		subcategories = subs;			
	}
	
	public boolean isCategoryType(String ct) {
		Category currCat = this;
		while (currCat.getParentCategory() != null) {
			if (currCat.getName().equals(ct)) {
				return true;
			}
			else {
				currCat = currCat.getParentCategory();
			}
		}
		
		return currCat.getName().equals(ct);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Category> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(ArrayList<Category> subcategories) {
		this.subcategories = subcategories;
	}
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	
	@Override
	public String toString() {
		String children = "";
		if (subcategories != null) {
			children = "\n";
			for (int i = 0; i < subcategories.size(); i++) {
				children += "\t" + subcategories.get(i).toString();
			}
		}
		return name + ", parent: " + (parentCategory == null? "null": parentCategory.getName()) + children;
	}
}
