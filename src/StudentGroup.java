
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
                
		
		return students;
	}

	@Override
	public void setStudents(Student[] students){
		// Add your implementation here
               try{
                   this.students=students;
                   throw new IllegalArgumentException();
               }catch(IllegalArgumentException e){
                   
               }
                
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
                try{
                    if(index<0 || index>=students.length){
                    throw new IllegalArgumentException();
                    }
                }catch(IllegalArgumentException e){
                    
                }
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException {
		// Add your implementation here
               
                students[index]=student;
                
                
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException {
		// Add your implementation here
                Student[] students1=new Student[students.length+1];
                students1[0]=student;
                
                for(int i=1;i<students1.length;i++){
                    students1[i]=students[i-1];
                }
                
                
                setStudents(students1);
                
                
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException {
		// Add your implementation here
                Student[] students1=new Student[students.length+1];
                
            System.arraycopy(students, 0, students1, 0, students.length);
                students1[students1.length-1]=student;
                
                
                setStudents(students1);
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException {
		// Add your implementation here
                 Student[] students1=new Student[students.length+1];
                 for (int i = 0; i < index; i++) {
                     students1[i]=students[i];
                                 }
                 students1[index]=student;
                 for (int i = index+1; i < students1.length; i++) {
                     students1[i]=students[i-1];
            }
                 
                
                setStudents(students1);
	}

	@Override
	public void remove(int index) throws IllegalArgumentException{
            
		// Add your implementation here
                Student[] students1=new Student[students.length-1];
                for(int i=0;i<index;i++){
                    students1[i]=students[i];
                }
                for(int i=index+1;i<students.length;i++){
                    students1[index-1]=students[i];
                }
                setStudents(students1);
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException{
		// Add your implementation here
                boolean contains= Arrays.asList(students).contains(student);
                if(contains){
                    int index=Arrays.asList(students).indexOf(student);
                    remove(index);
                }
                else{
                    throw new IllegalArgumentException("Student not exist");
                }
	}

	@Override
	public void removeFromIndex(int index) throws IllegalArgumentException {
            
		// Add your implementation here
                Student[] students1=new Student[index+1];
            System.arraycopy(students, 0, students1, 0, index);
                setStudents(students1);
                
	}

	@Override
	public void removeFromElement(Student student) throws IllegalArgumentException {
		// Add your implementation here
                int index=Arrays.asList(students).indexOf(student);
                removeFromIndex(index);
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
                 Student[] students1=new Student[students.length-index];
            System.arraycopy(students, index, students1, 0, students.length-index);
                setStudents(students1);
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
                int index=Arrays.asList(students).indexOf(student);
                removeToIndex(index);
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
                Student temp;
                for(int i=0;i<students.length;i++){
                    for (int j = 0; j < students.length; j++) {
                        if((students[j].compareTo(students[i]))==1){
                            temp=students[j];
                            students[j]=students[j+1];
                            students[j+1]=temp;
                        }
                    }
                }
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
                ArrayList<Student> studentList=new ArrayList<>();
                
            for (Student student : students) {
                if (student.getBirthDate().equals(date)) {
                    studentList.add(student);
                }
            }
            Student[] students1;
            students1=studentList.toArray(new Student[studentList.size()]);
		return students1;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
                ArrayList<Student> studentList=new ArrayList<>();
                for (Student student : students) {
                        if ((student.getBirthDate().compareTo(firstDate)>=0) &&
                                (student.getBirthDate().compareTo(lastDate)<=0)) {
                    studentList.add(student);
                }
            }
                Student[] students1;
            students1=studentList.toArray(new Student[studentList.size()]);
		return students1;
		
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
                GregorianCalendar cal=new GregorianCalendar();
                cal.setTime(date);
                cal.add(Calendar.DATE, days);
                
		Date date2=cal.getTime();
                return getBetweenBirthDates(date, date2);
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) throws IllegalArgumentException{
		// Add your implementation here
		int age=0;
			Calendar dob=Calendar.getInstance();
			dob.setTime(students[indexOfStudent].getBirthDate());
			Calendar now=Calendar.getInstance();
			int year1 = now.get(Calendar.YEAR);
		    int year2 = dob.get(Calendar.YEAR);
		    age = year1 - year2;
		    int month1 = now.get(Calendar.MONTH);
		    int month2 = dob.get(Calendar.MONTH);
		    if (month2 > month1) {
		        age--;
		    } else if (month1 == month2) {
		        int day1 = now.get(Calendar.DAY_OF_MONTH);
		        int day2 = dob.get(Calendar.DAY_OF_MONTH);
		        if (day2 > day1) {
		            age--;
		        }
		    }
			
			
		return age;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		ArrayList<Student> studentList=new ArrayList<>();
        for (int i=0;i<students.length;i++) {
        	int agenow=getCurrentAgeByDate(i);
            if (agenow==age) {
                studentList.add(students[i]);
            }
        }
        Student[] students1;
        students1=studentList.toArray(new Student[studentList.size()]);
	return students1;
		
		
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		ArrayList<Student> studentList=new ArrayList<>();
		double max=0.0;
		for (Student student:students){
			if(student.getAvgMark()>max){
				max=student.getAvgMark();
			}
		}
		for (Student student : students) {
			if(student.getAvgMark()==max){
				studentList.add(student);
			}
		}
		Student[] students1;
        students1=studentList.toArray(new Student[studentList.size()]);
	return students1;
	}

	@Override
	public Student getNextStudent(Student student) throws IllegalArgumentException {
		// Add your implementation here
		int index=Arrays.asList(students).indexOf(student);
		
		return getStudent(index+1);
	}
}
