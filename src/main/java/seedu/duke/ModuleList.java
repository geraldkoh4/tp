package seedu.duke;
import java.util.ArrayList;
import java.util.logging.Level;

import static seedu.duke.Duke.LOGGER;

public class ModuleList {
    private ArrayList<Module> listOfModules;
    public ModuleList() {
        this.listOfModules = new ArrayList<>();
    }
    public ArrayList<Module> getModuleList() {
        return listOfModules;
    }

    public int getModuleListSize() {
        return listOfModules.size();
    }

    public void addModule(String moduleCode, String modularCredits, String moduleType) {
        int oldSizeOfList = listOfModules.size();
        LOGGER.log(Level.INFO, "Starting addModule process");
        switch(moduleType.toUpperCase()) {
        case "CORE":
            Core newCore = new Core(moduleCode, modularCredits);
            listOfModules.add(newCore);
            Print.printAddedModule(newCore, listOfModules.size());
            break;
        case "GE":
            GeneralElective newGeneralElective = new GeneralElective(moduleCode, modularCredits);
            listOfModules.add(newGeneralElective);
            Print.printAddedModule(newGeneralElective, listOfModules.size());
            break;
        case "UE":
            UnrestrictedElective newUnrestrictedElective = new UnrestrictedElective(moduleCode, modularCredits);
            listOfModules.add(newUnrestrictedElective);
            Print.printAddedModule(newUnrestrictedElective, listOfModules.size());
            break;
        case "INTERNSHIP":
            Internship newinternship = new Internship(moduleCode, modularCredits);
            listOfModules.add(newinternship);
            Print.printAddedModule(newinternship, listOfModules.size());
            break;
        default:
            break;
        }
        assert listOfModules.size() == oldSizeOfList + 1 : "Module not added correctly";
        LOGGER.log(Level.INFO, "Finished addModule process");
    }

    public void findModule(String moduleCode) throws DukeException {
        if (listOfModules.size() == 0) {
            throw new DukeException("There are currently no modules in your list");
        }
        assert listOfModules.size() > 0 : "no items in list";
        LOGGER.log(Level.INFO, "Starting findModule process");
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                Print.printFoundModule(module);
                LOGGER.log(Level.INFO, "Finished findModule process with matching module found");
                return;
            }
        }
        Print.printNoModuleFound();
        LOGGER.log(Level.INFO, "Finished findModule process with no matching module found");
    }

    public void deleteModule(String moduleCode) throws DukeException {
        if (listOfModules.size() == 0) {
            throw new DukeException("There are currently no modules in your list");
        }
        assert listOfModules.size() > 0 : "no items in list";
        LOGGER.log(Level.INFO, "Starting deleteModule process");
        int oldSizeOfList = listOfModules.size();
        for (int i = 0; i < listOfModules.size(); i++) {
            if (listOfModules.get(i).getModuleCode().equals(moduleCode)) {
                Module deletedModule = listOfModules.get(i);
                listOfModules.remove(i);
                Print.printDeletedModule(deletedModule, listOfModules.size());
                break;
            }
        }
        assert listOfModules.size() == oldSizeOfList - 1 : "Module not deleted correctly";
        LOGGER.log(Level.INFO, "Finished deleteModule process");
    }

    public void listModules() {
        LOGGER.log(Level.INFO, "Starting listModules process");
        if (getModuleListSize() > 0) {
            Print.printModuleList(listOfModules);
        } else {
            Print.printEmptyModuleList();
        }
        LOGGER.log(Level.INFO, "Finished listModules process");
    }

    public void newAddModule(String moduleCode, String modularCredits,
                             String moduleType, String year, String semester) {
        int oldSizeOfList = listOfModules.size();
        LOGGER.log(Level.INFO, "Starting addModule process");
        switch (moduleType.toUpperCase()) {
            case "CORE":
                Core newCore = new Core(moduleCode, modularCredits, year, semester);
                listOfModules.add(newCore);
                Print.printAddedModule(newCore, listOfModules.size());
                break;
            case "GE":
                GeneralElective newGeneralElective = new GeneralElective(moduleCode, modularCredits, year, semester);
                listOfModules.add(newGeneralElective);
                Print.printAddedModule(newGeneralElective, listOfModules.size());
                break;
            case "UE":
                UnrestrictedElective newUnrestrictedElective =
                        new UnrestrictedElective(moduleCode, modularCredits, year, semester);
                listOfModules.add(newUnrestrictedElective);
                Print.printAddedModule(newUnrestrictedElective, listOfModules.size());
                break;
            case "INTERNSHIP":
                Internship newinternship = new Internship(moduleCode, modularCredits, year, semester);
                listOfModules.add(newinternship);
                Print.printAddedModule(newinternship, listOfModules.size());
                break;
            default:
                break;
        }
        assert listOfModules.size() == oldSizeOfList + 1 : "Module not added correctly";
        LOGGER.log(Level.INFO, "Finished addModule process");
    }

    public void editModularCredits(String moduleCode, String newModularCredits) {
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                module.editModularCredits(newModularCredits);
                Print.printEditedModule(module, listOfModules.size());
            }
        }
    }

    public void editYear(String moduleCode, String newYear) {
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                module.editYear(newYear);
                Print.printEditedModule(module, listOfModules.size());
            }
        }
    }

    public void editSemester(String moduleCode, String newSemester) {
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                module.editSemester(newSemester);
                Print.printEditedModule(module, listOfModules.size());
            }
        }
    }

    public String getModularCredits(String moduleCode) {
        String modularCredits = "";
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                modularCredits = module.getModularCredits();
            }
        }
        return modularCredits;
    }

    public String getYear(String moduleCode) {
        String year = "";
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                year = module.getYear();
            }
        }
        return year;
    }

    public String getSemester(String moduleCode) {
        String semester = "";
        for (Module module : listOfModules) {
            if (module.getModuleCode().equals(moduleCode)) {
                semester = module.getSemester();
            }
        }
        return semester;
    }

}
