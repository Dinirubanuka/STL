const {
page,
setPage,
title,
subtitle,
handleSubmit,
getValues,
setValue
} = useFormContext();
const [errMsg, setErrMsg] = useState('');
const handleClose = () => {
setErrMsg('');
};

const onSubmit = async (e) => {
if(page === 2){
const data = getValues();
try{
const response = await axios.post('register', data);
if(response.data.message === 'User added successfully'){
setPage(page + 1);
}else{
setErrMsg(response.data.message);
}
}catch(err){
setErrMsg(err.response.data.message);
}
}else{
setPage(page + 1);
}


};

const handlePrev = () => setPage(page - 1);
const handleNext = () => setPage(page + 1);

const navigate = useNavigate();
const handleButtonClick = () => {
navigate("/");
};

const { setAuth } = useAuth();

const navigate = useNavigate();
const userRef = useRef();

const [user, resetUser, userAttributes] = useInput("user", "");
const [pwd, setPwd] = useState("");
const [errMsg, setErrMsg] = useState("");
const [check, toggleCheck] = useToggle("persist", false);

const handleClose = () => {
setErrMsg("");
};

useEffect(() => {
userRef.current.focus();
}, []);

const isXsScreen = useMediaQuery((theme) => theme.breakpoints.down("sm"));
const formWidth = isXsScreen ? "70%" : "30%";

const handleSubmit = async (e) => {
e.preventDefault();
try {
const response = await axios.post(
"login",
JSON.stringify({ username: user, pass: pwd }),
{
headers: { "Content-Type": "application/json" },
withCredentials: true,
}
);

const role = response.data.userrole;
const accessToken = response.data.accessToken;
//decode phone
const phone = jwt_decode(accessToken).phone;
const userId = jwt_decode(accessToken).userId;
setAuth({ role, accessToken, phone, userId });
// resetUser();
// setPwd("");

if (role === "user") {
navigate("/general-user");
} else {
navigate("/surpport");
}
} catch (err) {
if (!err?.response) {
setErrMsg("Network error");
} else if (err.response?.status === 400) {
setErrMsg("Missing username or password");
} else if (err.response?.status === 401) {
setErrMsg("Unauthorized");
} else {
setErrMsg("Login failed, try again");
}
}
};