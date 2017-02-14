class StringSearch {

	public static int naiveSearch(String pattern,String text){
		for(int i=0;i<text.length()-pattern.length()+1;i++){
			int j=0;
			for(;j<pattern.length();j++){
				if(text.charAt(i+j)!=pattern.charAt(j))
					break;
			}
			if(j==pattern.length())
				return i;
		}
		return -1;
	}

	public static int rabinKarp(String pattern,String text){
		
		int hPattern=hash(pattern,0,pattern.length()-1);
		System.out.println("hPattern:"+pattern+" "+hPattern);
		for(int i=0;i<text.length()-pattern.length()+1;i++){
			//System.out.println("hText:");
			int hText=hash(text,i,i+pattern.length()-1);
			//System.out.println(hPattern+" "+hText);
			if(hText==hPattern){
				int j=0;
				for(;j<pattern.length();j++){
					if(text.charAt(i+j)!=pattern.charAt(j))
						break;
				}
				if(j==pattern.length())
					return i;		
			}
		}
		return -1;	
	}

	public static int rabinKarpPriceton(String pattern,String text){
		int M=pattern.length();
		int N=text.length();

		int h1=0,h2=0;
		int d=265;
		int q=3355439;
		
		
		for(int i=0;i<M;i++){
			char ch=pattern.charAt(i);
			h1=((h1*d)+ch)%q;
			ch=text.charAt(i);
			h2=((h2*d)+ch)%q;
			//System.out.print(h1+" ");
		}
		System.out.println("pattern:"+pattern+" "+h1);

		System.out.println(h1+" "+h2);
		if(h1==h2)
			return 0;
		
		for(int i=M;i<N;i++){
			h2=(h2-text.charAt(i-M))%q;
			h2=(h2*d+text.charAt(i))%q;
			//System.out.println(h1+" "+h2);
			if(h1==h2)
				return i-M;
		}
		return -1;


	}

	public static int hash(String str,int startIndex,int endIndex){
		int hash=0;
		int d=256;
		int q=3355439;
		for(int i=startIndex;i<=endIndex;i++){
			
			hash=(hash*d+str.charAt(i))%q;
		}
		//System.out.print(hash+" ");
		//System.out.println();
		return hash;
	}

	public static void main(String[] args) {
		String text="hi this is faisal raza my goal is to complete MIT course as soon as possible and start solving questions from hackerearth";
		String pattern="faisal";

		// text="AABAACAADAABAABA";
		// pattern="AABA";

		int index=naiveSearch(pattern,text);
		System.out.println("found at:"+index);
		System.out.println("rabinKarp");
		
		index=rabinKarp(pattern,text);
		System.out.println("found at:"+index);

		System.out.println("rabinKarpPriceton:");
		index=rabinKarpPriceton(pattern,text);
		
		System.out.println("found at:"+index);
	}
}